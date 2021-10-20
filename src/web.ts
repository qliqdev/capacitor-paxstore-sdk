import { WebPlugin } from '@capacitor/core';

import type {PaxstoreSdkPlugin} from './definitions';

export class PaxstoreSdkWeb extends WebPlugin implements PaxstoreSdkPlugin {
  echo(): Promise<{ value: string }> {
    throw this.unimplemented('Not implemented on web.');
  }

  init(): Promise<{value: string}> {
    throw this.unimplemented('Not implemented on web.');
  }

  checkInit(): Promise<{isInitialized: boolean}> {
    throw this.unimplemented('Not implemented on web.');
  }

  getInfo(): Promise<{value: any}> {
    throw this.unimplemented('Not implemented on web.');
  }

  startSale(): Promise<any> {
    throw this.unimplemented('Not implemented on web.');
  }
}
