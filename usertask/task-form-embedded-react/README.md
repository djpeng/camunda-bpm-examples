# Creating custom Forms using React
React is a popular library to build user interfaces. If you want to use react to build custom tasklist forms, you can use this example as a starting point. We adapted the [React Multiple Inputs Example](https://reactjs.org/docs/forms.html#handling-multiple-inputs) and integrated it into a process.

## Overview
### How can I add React to my Tasklist?
  1. Download [React](https://unpkg.com/react/umd/) and [reactDOM](https://unpkg.com/react-dom/umd/) into the `app/tasklist/scripts/react` of your webapp.
  2. Add [loadReact.js](config/react/loadReact.js) to the same folder. This will add React and ReactDOM to the global scope
  3. Add everything as a custom script in `app/tasklist/scripts/config.js`. If you use the production build of react, change the path accordingly.
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
1. Checkout the project with Git
2. Build the project with maven
3. Deploy the war file to a camunda BPM platform distribution
4. Add React to your webapp as described above
5. Go the the Tasklist and start a process instance for the process named "React Example"
