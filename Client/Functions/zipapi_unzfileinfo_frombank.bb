Function zipapi_unzfileinfo_frombank.zipapi_unzfileinfo(arg0%)
    Local local0.zipapi_unzfileinfo
    Local local1%
    If (arg0 < $01) Then
        Return Null
    EndIf
    If (banksize(arg0) <> $50) Then
        Return Null
    EndIf
    local0 = (New zipapi_unzfileinfo)
    local0\Field0 = peekint(arg0, $00)
    local0\Field1 = peekint(arg0, $04)
    local0\Field2 = peekint(arg0, $08)
    local0\Field3 = peekint(arg0, $0C)
    local0\Field4 = peekint(arg0, $10)
    local0\Field5 = peekint(arg0, $14)
    local0\Field6 = peekint(arg0, $18)
    local0\Field7 = peekint(arg0, $1C)
    local0\Field15 = peekint(arg0, $20)
    local0\Field16 = peekint(arg0, $24)
    local0\Field17 = peekint(arg0, $28)
    local0\Field8 = peekint(arg0, $2C)
    local0\Field9 = peekint(arg0, $30)
    local0\Field10 = peekint(arg0, $34)
    local1 = createbank($18)
    copybank(arg0, $38, local1, $00, $18)
    local0\Field11 = zipapi_date_frombank(local1)
    freebank(local1)
    Return local0
    Return Null
End Function
