Function zipapi_date_frombank.zipapi_date(arg0%)
    Local local0.zipapi_date
    If (banksize(arg0) < $18) Then
        Return Null
    EndIf
    local0 = (New zipapi_date)
    local0\Field0 = peekint(arg0, $00)
    local0\Field1 = peekint(arg0, $04)
    local0\Field2 = peekint(arg0, $08)
    local0\Field3 = peekint(arg0, $0C)
    local0\Field4 = peekint(arg0, $10)
    local0\Field5 = peekint(arg0, $14)
    Return local0
    Return Null
End Function
