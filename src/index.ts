import { registerPlugin } from '@capacitor/core';

import type { PaxstoreSdkPlugin } from './definitions';

const PaxstoreSdk = registerPlugin<PaxstoreSdkPlugin>('PaxstoreSdk', {
  web: () => import('./web').then(m => new m.PaxstoreSdkWeb()),
});

export * from './definitions';
export { PaxstoreSdk };
