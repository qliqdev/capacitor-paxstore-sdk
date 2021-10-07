export interface PaxstoreSdkPlugin{
    /**
     * Initialize sdk.
     * @param options: {value: string} Get from offsite.
     * @returns {Promise<{ value: string }>}
     * @since 1.0.0
     * @example
     * import PaxstoreSdk from 'capacitor-paxstore-sdk';
     */
    echo(options: { value: string }): Promise<{ value: string }>;

    /**
     * Initialize sdk.
     * @param options: {appKey: string, appSecret: string} Get from offsite.
     * @returns {Promise<{ value: string }>}
     * @since 1.0.0
     * @example
     * import PaxstoreSdk from 'capacitor-paxstore-sdk';
     */
    init(options: InitOptions): Promise<{ value: string }>;
}

export interface InitOptions {
    appkey: string;
    appSecret: string;
}