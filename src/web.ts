import { WebPlugin } from '@capacitor/core';

import type { PaxstoreSdkPlugin } from './definitions';

export class PaxstoreSdkWeb extends WebPlugin implements PaxstoreSdkPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
