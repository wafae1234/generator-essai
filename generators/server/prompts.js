module.exports = {
    prompting
};

function prompting() {

    const done = this.async();

    const prompts = [
        {
            type: 'string',
            name: 'appName',
            message: 'What is the application name?',
            default: 'server'
        },
        {
            type: 'string',
            name: 'packageName',
            message: 'What is the default package name?',
            default: 'com.mycompany.myapp'
        }
    ];

    this.prompt(prompts).then(answers => {
        Object.assign(this.configOptions, answers);
        this.configOptions.packageFolder = this.configOptions.packageName.replace(/\./g, '/');
        done();
    });
}