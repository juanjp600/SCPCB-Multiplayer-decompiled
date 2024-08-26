Function zipapi_getcurrentfileinfo.zipapi_unzfileinfo(arg0%)
    Local local0.zipapi_unzfileinfo
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    If (arg0 < $01) Then
        Return Null
    EndIf
    local0 = zipapi_getcurrentfileinfofast(arg0)
    local1 = createbank($50)
    local2 = createbank((local0\Field15 + $01))
    local3 = createbank((local0\Field16 + $01))
    local4 = createbank((local0\Field17 + $01))
    zlibwapi_unzgetcurrentfileinfo(arg0, local1, local2, local0\Field15, local3, local0\Field16, local4, local0\Field17)
    local0\Field12 = peekstring(local2, $00)
    local0\Field13 = peekstring(local3, $00)
    local0\Field14 = peekstring(local4, $00)
    freebank(local1)
    freebank(local2)
    freebank(local3)
    freebank(local4)
    Return local0
    Return Null
End Function
