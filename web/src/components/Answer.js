import React from 'react';
import { BsChevronUp, BsChevronDown } from "react-icons/bs";

export const Answer = ({ answer, voteUp, voteDown }) => (
  <aside className="answer">
    <div className="container-answer">
      <p>{answer.answer}</p>
      <div className="position-answer">
        <button className="button-icon" onClick={ () => voteUp(answer) } ><BsChevronUp size="25"/></button>
        <h4 style={{ margin: "0 0 0 0" }}>{ answer.position }</h4>
        <button className="button-icon" onClick={ () => voteDown(answer) }><BsChevronDown size="25"/></button>
      </div>
    </div>
  </aside>
)
