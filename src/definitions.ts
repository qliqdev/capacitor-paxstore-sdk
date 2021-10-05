export interface PaxstoreSdkPlugin {
    init(options: InitOptions): Promise<any>;
}

export interface InitOptions {
    appkey: string;
    appSecret: string;
}