Function initloadingscreens%(arg0$)
    Local local0%
    local0 = jsonparsefromfile((lang\Field1 + arg0))
    If (jsonisarray(local0) <> 0) Then
        loadingscreens = jsongetarray(local0)
    Else
        loadingscreens = jsongetarray(jsonparsefromfile(arg0))
    EndIf
    Return $00
End Function
