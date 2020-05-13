module.exports = {
    prompting
};

function prompting() {

    const done = this.async();

    const prompts = [
        {
            type: 'list',
            name: 'appType',
            message: 'Which part of the application you want to generate?',
            choices: [
                {
                    value: 'client',
                    name: 'client side'
                },
                {
                    value: 'server',
                    name: 'Server side'
                }
            ],
            default: 'server'
        }
    ];

    this.prompt(prompts).then(answers => {
        Object.assign(this.configOptions, answers);
        done();
    });
}