import { WebPlugin } from '@capacitor/core';

import type {InitOptions, PaxstoreSdkPlugin} from './definitions';

export class PaxstoreSdkWeb extends WebPlugin implements PaxstoreSdkPlugin {
  async init(options: InitOptions): Promise<any> {
    console.log('ECHO', options);
    return options;
  }
}
