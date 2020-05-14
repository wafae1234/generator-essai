'use strict';
const BaseGenerator = require('../base-generator');
const constants = require('../constants');
const prompts = require('./prompts');
const path = require('path');

module.exports = class extends BaseGenerator {

    constructor(args, opts) {
        super(args, opts);

        this.configOptions = this.options.configOptions || {};
    }

    initializing() {
        this.logSuccess('Generating Server side');
    }

    get prompting() {
        return prompts.prompting;
    }

    configuring() {
        this.destinationRoot(path.join(this.destinationRoot(), '/'+this.configOptions.appName));
        Object.assign(this.configOptions, constants);
        this.config.set(this.configOptions);
    }

    writing() {
         this.generateBuildToolConfig(this.configOptions);
        this._generateAppCode(this.configOptions);
    }

    end() {
        this.printGenerationSummary(this.configOptions);
    }

    _generateAppCode(configOptions) {
        const mainJavaTemplates = [
            'ContactApplication.java',
            'config/SecurityConfigurer.java',
            'rest/AccountRestController.java',
            'rest/AppRoleRestService.java',
            'rest/AppUserRestService.java',
            'rest/AuditRestService.java',
            'rest/PermissionRestService.java',

            'security/AuthenticationRequest.java',
            'security/AuthenticationResponse.java',
            'security/JwtRequestFilter.java',
            'security/JwtUtil.java',

            'service/audit/AuditService.java',
            'service/audit/AuditServiceImpl.java',
            'service/audit/BeanUtil.java',
            'service/audit/Operation.java',
            'service/AccountService.java',
            'service/AccountServiceImpl.java',
            'service/MyUserDetailsService.java',
            'service/PermissionService.java',
            'service/PermissionServiceImpl.java',
            'service/RegisterFormService.java',
            'service/RegisterFormServiceImpl.java',
            'service/RoleService.java',
            'service/RoleServiceImpl.java',
            'service/UserService.java',
            'service/UserServiceImpl.java'

        ];
        this.generateMainJavaCode(configOptions, mainJavaTemplates);

        const mainResTemplates = [
            'application.properties'
        ];
        this.generateMainResCode(configOptions, mainResTemplates);

        const testJavaTemplates = [
            'AuditTest.java',
            'ContactApplicationTests.java'
        ];
        this.generateTestJavaCode(configOptions, testJavaTemplates);
    }

};