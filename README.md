# capacitor-paxstore-sdk

Communicate with Paxstore SDK, to receive data from POS treminals.

## Install

```bash
npm install capacitor-paxstore-sdk
npx cap sync
```

## API

<docgen-index>

* [`init(...)`](#init)
* [`checkInit()`](#checkinit)
* [`startSale(...)`](#startsale)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### init(...)

```typescript
init(options: InitOptions) => any
```

Initialize sdk.

| Param         | Type                                                | Description                                                                                  |
| ------------- | --------------------------------------------------- | -------------------------------------------------------------------------------------------- |
| **`options`** | <code><a href="#initoptions">InitOptions</a></code> | : {appKey: string, appSecret: string, packageName: 'com.pax.psp_3rd_app'}` Get from offsite. |

**Returns:** <code>any</code>

**Since:** 1.0.0

--------------------


### checkInit()

```typescript
checkInit() => any
```

Check Initialization.

**Returns:** <code>any</code>

**Since:** 1.0.8

--------------------


### startSale(...)

```typescript
startSale(options: SaleOptions) => any
```

Start Sale
API to start payment

| Param         | Type                                                |
| ------------- | --------------------------------------------------- |
| **`options`** | <code><a href="#saleoptions">SaleOptions</a></code> |

**Returns:** <code>any</code>

**Since:** 1.0.9

--------------------


### Interfaces


#### InitOptions

| Prop              | Type                |
| ----------------- | ------------------- |
| **`appKey`**      | <code>string</code> |
| **`appSecret`**   | <code>string</code> |
| **`packageName`** | <code>string</code> |


#### SaleOptions

| Prop         | Type                |
| ------------ | ------------------- |
| **`amount`** | <code>string</code> |

</docgen-api>
