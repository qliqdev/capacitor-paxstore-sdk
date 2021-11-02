export interface InitOptions {
    appKey: string;
    appSecret: string;
    packageName: string;
}

export interface SaleOptions {
    amount: string;
}

export interface ReversalOptions {
    rrn: string;
}

export interface RefundOptions {
    amount: string;
    rrn: string;
}

export interface PrintTransOptions {
    etVoucherNo: string;
}

export interface PrintTransTotalOptions {
    etPrintType: string;
}

export interface PaxstoreSdkPlugin{

    /**
     * Initialize sdk.
     * @param `options: {appKey: string, appSecret: string, packageName: 'com.pax.psp_3rd_app'}`
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
     * Start Sale
     * API to start payment
     * @returns Promise<{ value: any }>
     * @since 1.0.9
     * @example
     * import PaxstoreSdk from 'capacitor-paxstore-sdk';
     */

    startSale(options: SaleOptions): Promise<{ value: any }>;

    /**
     * Start Reversal
     * API to start reversal
     * @param `options: {rrn: string}`
     * @returns Promise<{ value: any }>
     * @since 1.0.20
     * @example
     * import PaxstoreSdk from 'capacitor-paxstore-sdk';
     */
    startReversal(options: ReversalOptions): Promise<{ value: any }>;

    /**
     * Start Refund
     * API to start reversal
     * @param `options: {amount: string, rrn: string}`
     * @returns Promise<{ value: any }>
     * @since 1.0.20
     * @example
     * import PaxstoreSdk from 'capacitor-paxstore-sdk';
     */
    startRefund(options: RefundOptions): Promise<{ value: any }>;

    /**
     * Start Print Transaction
     * API to start Print Transaction
     * @param `options: {etVoucherNo: string}`
     * @returns Promise<{ value: any }>
     * @since 1.0.20
     * @example
     * import PaxstoreSdk from 'capacitor-paxstore-sdk';
     */
    startPrintTrans(options: PrintTransOptions): Promise<{ value: any }>;

    /**
     * Start Print Transaction Total
     * API to start Print Transaction Total
     * @param `options: {etPrintType: string}`
     * @returns Promise<{ value: any }>
     * @since 1.0.20
     * @example
     * import PaxstoreSdk from 'capacitor-paxstore-sdk';
     */
    startPrintTransTotal(options: PrintTransTotalOptions): Promise<{ value: any }>;
}