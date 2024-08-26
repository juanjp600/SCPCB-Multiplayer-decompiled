Function zipapi_getcurrentfileinfofast.zipapi_unzfileinfo(arg0%)
    Local local0.zipapi_unzfileinfo
    Local local1%
    Local local2%
    If (arg0 < $01) Then
        Return Null
    EndIf
    local0 = Null
    local1 = createbank($50)
    local2 = createbank($00)
    zlibwapi_unzgetcurrentfileinfo(arg0, local1, local2, $00, local2, $00, local2, $00)
    local0 = zipapi_unzfileinfo_frombank(local1)
    If (local0 = Null) Then
        Return Null
    EndIf
    freebank(local2)
    freebank(local1)
    Return local0
    Return Null
End Function
