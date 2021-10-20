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
* [`checkInit()`](#checkinit)
* [`getInfo()`](#getinfo)
* [`startSale(...)`](#startsale)
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


### checkInit()

```typescript
checkInit() => any
```

Check Initialization.

**Returns:** <code>any</code>

**Since:** 1.0.8

--------------------


### getInfo()

```typescript
getInfo() => any
```

Get Terminal Base Information
API to get base terminal information from PAXSTORE client. (Support from PAXSTORE client V6.1.)

**Returns:** <code>any</code>

**Since:** 1.0.7

--------------------


### startSale(...)

```typescript
startSale(amount: number) => any
```

Start Sale
API to start payment

| Param        | Type                |
| ------------ | ------------------- |
| **`amount`** | <code>number</code> |

**Returns:** <code>any</code>

**Since:** 1.0.9

--------------------


### Interfaces


#### InitOptions

| Prop            | Type                |
| --------------- | ------------------- |
| **`appKey`**    | <code>string</code> |
| **`appSecret`** | <code>string</code> |

</docgen-api>
