export interface PaxstoreSdkPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
