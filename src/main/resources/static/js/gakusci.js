'use strict';

const query = React.createElement(
  'input',
  {id: "query", type: "text", name: "q"}
);

const searchSubmit = React.createElement(
  'input',
  {id: "search", type: "submit"}
);

function GakuForm() {
  return React.createElement(
    'form',
    {action: "/search"},
    query,
    searchSubmit
  );
}

// <input id="query" type="text" name="q"/>
// <input id="search" type="submit"/>

const domContainer = document.querySelector('#search_form');
ReactDOM.render(React.createElement(GakuForm), domContainer);
