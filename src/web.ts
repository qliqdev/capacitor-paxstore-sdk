import { WebPlugin } from '@capacitor/core';

import type {PaxstoreSdkPlugin} from './definitions';

export class PaxstoreSdkWeb extends WebPlugin implements PaxstoreSdkPlugin {
  init(): Promise<{value: string}> {
    throw this.unimplemented('Not implemented on web.');
  }

  checkInit(): Promise<{isInitialized: boolean}> {
    throw this.unimplemented('Not implemented on web.');
  }

  startSale(): Promise<boolean> {
    throw this.unimplemented('Not implemented on web.');
  }
}
