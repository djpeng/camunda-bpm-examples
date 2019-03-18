# Creating custom Forms using React
React is a popular library to build user interfaces. If you want to use react to build custom tasklist forms, you can use this example as a starting point. We adapted the [React Multiple Inputs Example](https://reactjs.org/docs/forms.html#handling-multiple-inputs) and integrated it into the process.

## Overview
### How can I add React to my Tasklist?
First, download react and reactDOM to the `app/tasklist/scripts/react` in your Camunda webapp .war file. The `loadReact.js` script adds them to the global scope.
Finally, add them as custom scripts in `app/tasklist/scripts/config.js`:

```
  customScripts: {
    ngDeps: [],
    deps: ['loadReact', 'react', 'react-dom'],
    paths: {
      'loadReact': 'scripts/react/loadReact',
      'react': 'scripts/react/react.development',
      'react-dom': 'scripts/react/react-dom.development'
    }
  }
```

That's it, you can now use react in your custom forms.

### How can I get access to process variables?
All process variables will be managed with the `camForm.variableManager`. You need to load existing and create new variables. How this is done is described in detail in the [Embedded Forms Reference](https://docs.camunda.org/manual/7.10/reference/embedded-forms/javascript/lifecycle/).

Keep in mind that you also have to update the variables this way if they change. You can do this in the `componentDidUpdate()` method of you form component. 

```javascript
componentDidUpdate() {
    $scope.$$camForm.$dirty = true;
    camForm.variableManager.variableValue('isGoing', this.state.isGoing);
    camForm.variableManager.variableValue('numberOfGuests', this.state.numberOfGuests);
}
```

### Can I use JSX?
Yes you can. Just use any JSX preprocessor as you would with any other React project.

## How to use this example
1. Add React to your webapp as described above
2. Deploy the diagramm with `start-form.html` and `task-form.html`
