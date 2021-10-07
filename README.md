# capacitor-paxstore-sdk

Communicate with Paxstore SDK, to receive data from POS treminals.

## Install

```bash
npm install capacitor-paxstore-sdk
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`init(...)`](#init)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => any
```

Initialize sdk.

| Param         | Type                            | Description                         |
| ------------- | ------------------------------- | ----------------------------------- |
| **`options`** | <code>{ value: string; }</code> | : {value: string} Get from offsite. |

**Returns:** <code>any</code>

**Since:** 1.0.0

--------------------


### init(...)

```typescript
init(options: InitOptions) => any
```

Initialize sdk.

| Param         | Type                                                | Description                                             |
| ------------- | --------------------------------------------------- | ------------------------------------------------------- |
| **`options`** | <code><a href="#initoptions">InitOptions</a></code> | : {appKey: string, appSecret: string} Get from offsite. |

**Returns:** <code>any</code>

**Since:** 1.0.0

--------------------


### Interfaces


#### InitOptions

| Prop            | Type                |
| --------------- | ------------------- |
| **`appkey`**    | <code>string</code> |
| **`appSecret`** | <code>string</code> |

</docgen-api>
