Function updatelaunchertick%(arg0%, arg1%, arg2%, arg3%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    local0 = $14
    local1 = $14
    local2 = mouseon(arg0, arg1, local0, local1)
    If (arg3 <> 0) Then
        local3 = menugray
    Else
        local3 = menuwhite
    EndIf
    color($FF, $FF, $FF)
    rendertiledimagerect(local3, (arg0 Mod $100), (arg1 Mod $100), $200, $200, arg0, arg1, local0, local1)
    If (local2 <> 0) Then
        If (arg3 <> 0) Then
            color($00, $00, $00)
            If (mo\Field0 <> 0) Then
                playsound_strict(buttonsfx[$01], $00, $01)
            EndIf
        Else
            color($32, $32, $32)
            If (mo\Field0 <> 0) Then
                arg2 = (arg2 = $00)
                playsound_strict(buttonsfx[$00], $00, $01)
            EndIf
        EndIf
    Else
        color($00, $00, $00)
    EndIf
    rect((arg0 + $02), (arg1 + $02), (local0 - $04), (local1 - $04), $01)
    If (arg2 <> 0) Then
        local4 = (($37 * local2) + $C8)
        color(local4, local4, local4)
        rendertiledimagerect(local3, (arg0 Mod $100), (arg1 Mod $100), $200, $200, (arg0 + $04), (arg1 + $04), (local0 - $08), (local1 - $08))
    EndIf
    color($FF, $FF, $FF)
    Return arg2
    Return $00
End Function
