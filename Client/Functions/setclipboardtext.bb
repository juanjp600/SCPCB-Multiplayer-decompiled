Function setclipboardtext%(arg0$)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    If (api_openclipboard($00) = $00) Then
        Return $00
    EndIf
    If (api_isclipboardformatavailable($01) = $00) Then
        Return $00
    EndIf
    local0 = api_globalalloc($02, (len(arg0) + $01))
    If (local0 <> $00) Then
        local1 = api_globallock(local0)
        If (local1 <> $00) Then
            local2 = createbank((len(arg0) + $01))
            For local3 = $01 To len(arg0) Step $01
                pokebyte(local2, (local3 - $01), asc(mid(arg0, local3, $01)))
            Next
            api_lstrcpy(local1, local2)
            api_globalunlock(local0)
            api_emptyclipboard()
            api_setclipboarddata($01, local0)
            api_closeclipboard()
            freebank(local2)
        EndIf
        api_globalfree(local0)
    EndIf
    Return $00
End Function
