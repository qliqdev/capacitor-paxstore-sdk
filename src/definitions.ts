export interface InitOptions {
    appKey: string;
    appSecret: string;
    packageName: string;
}

export interface SaleOptions {
    amount: string;
}

export interface PaxstoreSdkPlugin{
    /**
     * Initialize sdk.
     * @param options: {value: string} Get from offsite.
     * @returns Promise<{ value: string }>
     * @since 1.0.0
     * @example
     * import PaxstoreSdk from 'capacitor-paxstore-sdk';
     */
    echo(options: { value: string }): Promise<{ value: string }>;

    /**
     * Initialize sdk.
     * @param options: {appKey: string, appSecret: string, packageName: 'com.pax.psp_3rd_app'}
     * Get from offsite.
     * @returns Promise<{ value: string }>
     * @since 1.0.0
     * @example
     * import PaxstoreSdk from 'capacitor-paxstore-sdk';
     * Use `packageName: 'com.pax.psp_3rd_app'`;
     */
    init(options: InitOptions): Promise<{ value: string }>;

    /**
     * Check Initialization.
     * @returns Promise<boolean>
     * @since 1.0.8
     * @example
     * import PaxstoreSdk from 'capacitor-paxstore-sdk';
     */
    checkInit():Promise<{isInitialized: boolean}>;

    /**
     * Get Terminal Base Information
     * API to get base terminal information from PAXSTORE client. (Support from PAXSTORE client V6.1.)
     * @returns Promise<{ value: any }>
     * @since 1.0.7
     * @example
     * import PaxstoreSdk from 'capacitor-paxstore-sdk';
     */
    getInfo(): Promise<{ value: any }>;

    /**
     * Start Sale
     * API to start payment
     * @returns Promise<{ amount: any }>
     * @since 1.0.9
     * @example
     * import PaxstoreSdk from 'capacitor-paxstore-sdk';
     */
    startSale(options: SaleOptions): Promise<boolean>;
}