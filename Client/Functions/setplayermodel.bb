Function setplayermodel%(arg0.mp_player, arg1%, arg2%)
    Local local0.mp_playermodel
    Local local1.mp_modelmeshpreset
    local0 = arg0\Field35
    local1 = getplayermodelmeshpreset(arg1)
    If (local1 = Null) Then
        flushplayermodel(arg0)
        If (local0\Field17 <> $00) Then
            local0\Field17 = $00
            markplayerasupdated(arg0)
        EndIf
        Return $00
    EndIf
    If (arg2 = $00) Then
        Select arg1
            Case $01
                setplayermodeltexture(arg0, rand($01, $03), $00)
            Case $03
                setplayermodeltexture(arg0, $05, $00)
            Case $04
                setplayermodeltexture(arg0, $06, $00)
            Case $02
                setplayermodeltexture(arg0, $04, $00)
        End Select
    Else
        setplayermodeltexture(arg0, local0\Field11, $00)
    EndIf
    local0\Field19 = local1\Field11
    local0\Field20 = local1\Field12
    local0\Field10 = $00
    local0\Field11 = $00
    If (local0\Field17 <> arg1) Then
        local0\Field17 = arg1
        flushplayermodel(arg0)
        markplayerasupdated(arg0)
    EndIf
    Return $00
End Function
