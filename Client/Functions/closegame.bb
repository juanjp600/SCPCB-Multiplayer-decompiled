Function closegame%()
    Local local0%
    local0 = api_openprocess($01, $00, api_getcurrentprocessid())
    api_terminateprocess(local0, $01)
    api_closehandle(local0)
    clearworld($01, $01, $01)
    endgraphics()
    end()
    Return $00
End Function
