Function destroywindow%()
    Local local0%
    If (win <> Null) Then
        freeallfonts()
        clearworld($01, $01, $01, $01)
        aldestroy()
        local0 = api_openprocess($01, $00, win\Field11)
        If (local0 <> $00) Then
            api_terminateprocess(local0, $01)
            api_closehandle(local0)
        EndIf
    EndIf
    end()
    Return $00
End Function
