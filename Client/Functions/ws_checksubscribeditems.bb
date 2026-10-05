Function ws_checksubscribeditems%(arg0%)
    Local local0%
    Local local1%
    Local local2$
    Local local3$
    If (filetype("workshop") = $00) Then
        createdir("workshop")
    EndIf
    If (filetype("workshop\languages") = $00) Then
        createdir("workshop\languages")
    EndIf
    steam_loadsubscribeditems()
    local0 = steam_getsubscribeditemcount()
    For local1 = $00 To (local0 - $01) Step $01
        local2 = steam_getsubscribeditemid(local1)
        local3 = steam_getsubscribeditempath(local1)
        If ((arg0 And (local3 <> "")) <> 0) Then
            copyworkshopfiles(local3)
        EndIf
    Next
    Return $00
End Function
