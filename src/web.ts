import { WebPlugin } from '@capacitor/core';

import type {PaxstoreSdkPlugin} from './definitions';

export class PaxstoreSdkWeb extends WebPlugin implements PaxstoreSdkPlugin {
  echo(): Promise<{ value: string }> {
    throw this.unimplemented('Not implemented on web.');
  }

  init(): Promise<{value: string}> {
    throw this.unimplemented('Not implemented on web.');
  }
}
