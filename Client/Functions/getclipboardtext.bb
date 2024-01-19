Function getclipboardtext$()
    Local local0$
    If (api_openclipboard($00) = $00) Then
        Return ""
    EndIf
    If (api_isclipboardformatavailable($01) = $00) Then
        Return ""
    EndIf
    local0 = api_getclipboarddatatext($01)
    api_closeclipboard()
    Return local0
    Return ""
End Function
