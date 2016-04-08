# autovivification-map

Got sick of this pattern ?

```java
if(!map.containsKey(key)) {
  map.put(key, defaultValue);
}
return map.get(key);
```

Then AutovivificationMap is made for you ! 