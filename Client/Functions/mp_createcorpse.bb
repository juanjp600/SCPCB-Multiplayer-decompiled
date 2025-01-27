Function mp_createcorpse.mp_playercorpse(arg0#, arg1#, arg2#, arg3#, arg4%, arg5%, arg6.mp_player, arg7%, arg8%, arg9%)
    Local local0.mp_modelmeshpreset
    Local local1%
    Local local2.mp_playercorpse
    Local local3%
    Local local4%
    Local local5.items
    If (arg4 = $00) Then
        Return Null
    EndIf
    local0 = getplayermodelmeshpreset(arg4)
    If (local0 = Null) Then
        Return Null
    EndIf
    If (arg9 = $FFFFFFFF) Then
        For local1 = $01 To $C7 Step $01
            If (mp_corpses[local1] = Null) Then
                arg9 = local1
                Exit
            EndIf
        Next
        If (arg9 = $FFFFFFFF) Then
            mp_flushcorpses()
            arg9 = $01
        EndIf
    ElseIf (mp_corpses[arg9] <> Null) Then
        Return Null
    EndIf
    local2 = (New mp_playercorpse)
    mp_corpses[arg9] = local2
    mp_setcorpsemodel(local2, arg0, arg1, arg2, arg3, arg4, arg5)
    local2\Field0 = arg9
    local2\Field10 = 21000.0
    If (arg8 = $FFFFFFFF) Then
        local3 = $FFFFFFFF
        For local1 = $00 To $03 Step $01
            If (local0\Field26[local1] <> $00) Then
                local3 = local1
            EndIf
        Next
        If (local3 >= $00) Then
            arg8 = rand($00, local3)
        EndIf
    EndIf
    If (arg8 >= $00) Then
        local4 = local0\Field26[arg8]
        extractanimseq(local2\Field2, getfirstpackedvalue(local4), getsecondpackedvalue(local4), $00)
        If (arg7 <> 0) Then
            animate(local2\Field2, $03, 200.0, $01, 0.0)
        Else
            animate(local2\Field2, $03, local0\Field27[arg8], $01, 0.0)
        EndIf
        local2\Field9 = arg8
    EndIf
    If (arg6 <> Null) Then
        local2\Field11 = arg6\Field5
        For local1 = $00 To $09 Step $01
            mp_setcorpseattachmodel(local2, local1, arg6\Field35\Field21[local1]\Field3)
        Next
        If (mp_ishoster() <> 0) Then
            local2\Field5 = $00
            For local5 = Each items
                If (local5\Field27 = arg6\Field5) Then
                    If (local2\Field5 = $0A) Then
                        removeitem(local5)
                    Else
                        local5\Field27 = $00
                        local5\Field15 = $01
                        local2\Field6[local2\Field5] = local5
                        local2\Field5 = (local2\Field5 + $01)
                    EndIf
                EndIf
            Next
        EndIf
    EndIf
    Return local2
    Return Null
End Function
