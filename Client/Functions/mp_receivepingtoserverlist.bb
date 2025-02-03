Function mp_receivepingtoserverlist%(arg0$, arg1%, arg2.mp_netbuffer, arg3%, arg4%)
    Local local0.mp_listserver
    Local local1.mp_listserver
    Local local2%
    Local local3%
    Local local4%
    Local local5$
    Local local6$
    Local local7$
    Local local8%
    Local local9%
    Local local10%
    If (arg2 = Null) Then
        For local0 = Each mp_listserver
            If (((local0\Field1 = arg1) And (local0\Field0 = arg0)) <> 0) Then
                local0\Field16 = (((local0\Field10 = $00) Shl $00) = $00)
                local0\Field2 = ((local0\Field0 + ":") + (Str local0\Field1))
                local0\Field3 = "-"
                local0\Field8 = "-"
                local0\Field4 = $00
                local0\Field5 = $00
                local0\Field6 = $00
            EndIf
        Next
    Else
        If (arg4 = $01) Then
            For local0 = Each mp_listserver
                If (((local0\Field1 = arg1) And (local0\Field0 = arg0)) <> 0) Then
                    local0\Field16 = $01
                    local1 = local0
                EndIf
            Next
        Else
            local2 = blitz_mp_readbyte0(arg2)
            local3 = blitz_mp_readbyte0(arg2)
            local4 = blitz_mp_readbyte0(arg2)
            local5 = blitz_mp_readline0(arg2)
            local6 = blitz_mp_readline0(arg2)
            local7 = blitz_mp_readline0(arg2)
            local8 = blitz_mp_readbyte0(arg2)
            local9 = (Int min((Float blitz_mp_readbyte0(arg2)), 4.0))
            If (difficulties[local9]\Field5 <> 0) Then
                blitz_mp_ignorebytes0(arg2, $04)
            EndIf
            local10 = blitz_mp_readbyte0(arg2)
            For local0 = Each mp_listserver
                If (((local0\Field1 = arg1) And (local0\Field0 = arg0)) <> 0) Then
                    local0\Field2 = local5
                    local0\Field3 = local6
                    local0\Field4 = local3
                    local0\Field5 = local4
                    local0\Field7 = local9
                    local0\Field8 = local7
                    local0\Field9 = local8
                    local0\Field6 = (Int min(max((Float arg3), 5.0), 65535.0))
                    local0\Field11 = (local10 * $3E8)
                    local0\Field16 = $01
                    local1 = local0
                EndIf
            Next
        EndIf
        If ((((local1 <> Null) And (arg4 = $01)) And (mp_getdialogindex() = $01)) <> 0) Then
            mp_showlocaldialog(getlocalstring("mpmenu", "information"), (((((((((((((((format(getlocalstring("mpmenu", "info.name"), local1\Field2, "%s") + "\n") + format(getlocalstring("mpmenu", "info.gamemode"), local1\Field3, "%s")) + "\n") + format(getlocalstring("mpmenu", "info.players"), (((Str local1\Field4) + " / ") + (Str local1\Field5)), "%s")) + "\n") + format(getlocalstring("mpmenu", "info.diff"), difficulties[local1\Field7]\Field0, "%s")) + "\n") + format(getlocalstring("mpmenu", "info.seed"), local1\Field8, "%s")) + "\n") + format(getlocalstring("mpmenu", "info.intro"), getbool(local1\Field9), "%s")) + "\n") + format(getlocalstring("mpmenu", "info.voice"), mp_voicegetbitrate(local1\Field11), "%s")) + "\n") + format(getlocalstring("mpmenu", "info.ping"), (Str local1\Field6), "%s")) + "\n"), getlocalstring("gui", "close"), "", $00, $01, $00)
        EndIf
    EndIf
    mp_fillserverlist(serverlist\Field4)
    Return $00
End Function
