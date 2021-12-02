import { WebPlugin } from '@capacitor/core';

import type {PaxstoreSdkPlugin} from './definitions';

export class PaxstoreSdkWeb extends WebPlugin implements PaxstoreSdkPlugin {
  init(): Promise<{value: string}> {
    throw this.unimplemented('Not implemented on web.');
  }

  checkInit(): Promise<{isInitialized: boolean}> {
    throw this.unimplemented('Not implemented on web.');
  }

  startSale(): Promise<{value: any}> {
    throw this.unimplemented('Not implemented on web.');
  }

  startReversal(): Promise<{value: any}> {
    throw this.unimplemented('Not implemented on web.');
  }

  startRefund(): Promise<{value: any}> {
    throw this.unimplemented('Not implemented on web.');
  }

  startPrintTrans(): Promise<{value: any}> {
    throw this.unimplemented('Not implemented on web.');
  }

  startPrintTransTotal(): Promise<{value: any}> {
    throw this.unimplemented('Not implemented on web.');
  }

  findPrinters(): Promise<{printers: any}> {
    throw this.unimplemented('Not implemented on web.');
  }

  setPrinter(): Promise<{success: boolean}> {
    throw this.unimplemented('Not implemented on web.');
  }

  printBill(): Promise<{success: boolean}> {
    throw this.unimplemented('Not implemented on web.');
  }
}
