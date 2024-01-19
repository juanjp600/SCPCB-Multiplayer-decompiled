Function onplayerconsole%(arg0%, arg1$)
    Local local0$
    Local local1.players
    Local local2%
    Local local4.events
    Local local5$
    Local local6$
    Local local7.players
    Local local9%
    Local local10.itemtemplates
    Local local11.items
    If (instr(arg1, " ", $01) > $00) Then
        local0 = lower(left(arg1, (instr(arg1, " ", $01) - $01)))
    Else
        local0 = lower(arg1)
    EndIf
    local1 = player[arg0]
    local2 = arg0
    Select lower(local0)
        Case "unlockexits"
            For local4 = Each events
                If (local4\Field0 = "gateaentrance") Then
                    local4\Field4 = 1.0
                    local4\Field1\Field29[$01]\Field5 = $01
                    local4\Field1\Field29[$01]\Field4 = $00
                ElseIf (local4\Field0 = "exit1") Then
                    local4\Field4 = 1.0
                    local4\Field1\Field29[$04]\Field5 = $01
                    local4\Field1\Field29[$04]\Field4 = $00
                EndIf
            Next
            remotedooron = $01
        Case "spawn"
            local5 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
            local0 = piece(local5, $01, " ")
            local6 = piece(local5, $02, " ")
            If (local0 <> local6) Then
                console_spawnnpc(local0, local6, arg0)
            Else
                console_spawnnpc(local0, "", arg0)
            EndIf
        Case "stfu","stopsound"
            For local4 = Each events
                If (local4\Field0 = "alarm") Then
                    If (local4\Field1\Field32[$00] <> Null) Then
                        removenpc(local4\Field1\Field32[$00], $00)
                    EndIf
                    If (local4\Field1\Field32[$01] <> Null) Then
                        removenpc(local4\Field1\Field32[$01], $00)
                    EndIf
                    If (local4\Field1\Field32[$02] <> Null) Then
                        removenpc(local4\Field1\Field32[$02], $00)
                    EndIf
                    positionentity(curr173\Field4, 0.0, 0.0, 0.0, $00)
                    resetentity(curr173\Field4)
                    showentity(curr173\Field0)
                    removeevent(local4)
                    Exit
                EndIf
            Next
            For local7 = Each players
                If (local7\Field0 <> $01) Then
                    udp_writebyte($2A)
                    udp_writebyte($01)
                    udp_sendmessage(local7\Field0)
                EndIf
            Next
        Case "notarget"
            local0 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
            Select local0
                Case "on","1","true"
                    notarget = $01
                Case "off","0","false"
                    notarget = $00
                Default
                    notarget = (notarget = $00)
            End Select
        Case "spawnitem"
            local0 = lower(right(arg1, (len(arg1) - instr(arg1, " ", $01))))
            local9 = $00
            For local10 = Each itemtemplates
                If (lower(local10\Field1) = local0) Then
                    local9 = $01
                    Exit
                ElseIf (lower(local10\Field2) = local0) Then
                    local9 = $01
                    Exit
                EndIf
            Next
            If (local9 = $01) Then
                local11 = createitem(local10\Field1, local10\Field2, entityx(player[local2]\Field13, $00), (entityy(getplayercamera(local2), $01) + 0.1), entityz(player[local2]\Field13, $00), $00, $00, $00, 1.0, $00, $01)
                entitytype(local11\Field1, $03, $00)
            EndIf
    End Select
    Return $00
End Function
