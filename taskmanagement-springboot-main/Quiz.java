import React, { Component } from 'react';
import PropTypes from 'prop-types';
import './Quiz.css';

class Quiz extends Component {
  constructor(props) {
    super(props);

    this.state = {
      currentQuestionIndex: 0,
      selectedOptionIndex: null,
      showResults: false,
      score: 0,
      questions: [
        {
          question: 'What is the capital of France?',
          options: ['Paris', 'Berlin', 'Madrid', 'London'],
          correctAnswerIndex: 0
        },
        {
          question: 'What is the largest planet in our solar system?',
          options: ['Mars', 'Jupiter', 'Venus', 'Saturn'],
          correctAnswerIndex: 1
        },
        {
          question: 'What is the currency of Japan?',
          options: ['Yen', 'Won', 'Dollar', 'Euro'],
          correctAnswerIndex: 0
        }
      ]
    };
  }

  handleOptionClick = (optionIndex) => {
    this.setState({
      selectedOptionIndex: optionIndex
    });
  }

  handleSubmit = () => {
    const { currentQuestionIndex, selectedOptionIndex, questions, score } = this.state;

    if (selectedOptionIndex !== null) {
      const question = questions[currentQuestionIndex];
      const isCorrect = question.correctAnswerIndex === selectedOptionIndex;

      this.setState({
        score: isCorrect ? score + 1 : score,
        selectedOptionIndex: null,
        currentQuestionIndex: currentQuestionIndex + 1
      });
    }
  }

  handleShowResultsClick = () => {
    this.setState({
      showResults: true
    });
  }

  renderQuiz = () => {
    const { currentQuestionIndex, selectedOptionIndex, questions } = this.state;
    const question = questions[currentQuestionIndex];

    return (
      <div>
        <h1 className="Quiz__question">{question.question}</h1>
        <ul className="Quiz__options">
          {question.options.map((option, index) => (
            <li
              key={index}
              className={`Quiz_option ${index === selectedOptionIndex ? 'Quiz_option--selected' : ''}`}
              onClick={() => this.handleOptionClick(index)}
            >
              {option}
            </li>
          ))}
        </ul>
        <button className="Quiz__button" onClick={this.handleSubmit} disabled={selectedOptionIndex === null}>Next</button>
      </div>
    );
  }

  renderResults = () => {
    const { questions, score } = this.state;
    const totalQuestions = questions.length;

    return (
      <div>
        <h1 className="Quiz__results">You scored {score} out of {totalQuestions}!</h1>
      </div>
    );
  }

  render() {
    const { currentQuestionIndex, showResults } = this.state;

    return (
      <div className="Quiz">
        {showResults ? this.renderResults() : this.renderQuiz()}
        {
        }
            </div>
);
}
}

Quiz.propTypes = {
// Add any prop types here
};