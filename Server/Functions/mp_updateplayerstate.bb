Function mp_updateplayerstate%(arg0.players)
    Local local0%
    Local local1.items
    Local local2%
    Local local3.players
    Local local4%
    local0 = arg0\Field30
    If ((arg0\Field120 And (arg0\Field122 < millisecs())) <> 0) Then
        arg0\Field120 = $00
    EndIf
    If (arg0\Field162 <> 0) Then
        arg0\Field120 = $01
    EndIf
    If (arg0\Field126 <> $00) Then
        If (arg0\Field35 = $06) Then
            If (arg0\Field127 = $00) Then
                For local1 = Each items
                    If (local1\Field22 = local0) Then
                        If (local1\Field3\Field2 = "microhid") Then
                            arg0\Field127 = local1\Field18
                            Exit
                        EndIf
                    EndIf
                Next
                If (arg0\Field127 <> $00) Then
                    arg0\Field126 = $01
                    arg0\Field128 = (millisecs() + $2710)
                Else
                    arg0\Field126 = $00
                EndIf
            ElseIf (arg0\Field128 < millisecs()) Then
                arg0\Field126 = $00
                arg0\Field128 = $00
                If (m_item[arg0\Field127] <> Null) Then
                    removeitem(m_item[arg0\Field127], $01)
                EndIf
                arg0\Field127 = $00
            EndIf
        Else
            arg0\Field126 = $00
        EndIf
    ElseIf (arg0\Field128 <> $00) Then
        arg0\Field128 = $00
        If (m_item[arg0\Field127] <> Null) Then
            removeitem(m_item[arg0\Field127], $01)
        EndIf
        arg0\Field127 = $00
    EndIf
    If (arg0\Field126 <> 0) Then
        entitypickmode(arg0\Field69, $00, $00)
        local2 = createpivot($00)
        positionentity(local2, entityx(getcamera(arg0\Field30), $01), entityy(getcamera(arg0\Field30), $01), entityz(getcamera(arg0\Field30), $01), $00)
        rotateentity(local2, arg0\Field16, arg0\Field3, 0.0, $00)
        If (entitypick(local2, 30.0) <> $00) Then
            For local3 = Each players
                If (arg0 <> local3) Then
                    If (((mp_isafriend(local3\Field36, arg0\Field36) = $00) And (local3\Field59 = $00)) <> 0) Then
                        If (1.0 > distance3(pickedx(), pickedy(), pickedz(), entityx(local3\Field62, $00), entityy(local3\Field62, $00), entityz(local3\Field62, $00))) Then
                            If (giveplayerhealth(local3\Field30, ((- getgundamage($06)) * fpsfactor), ("was killed by Micro-HID by " + arg0\Field15)) <> 0) Then
                                If (getscripts() <> 0) Then
                                    local4 = public_inqueue($19, $00)
                                    public_addparam(local4, (Str arg0\Field30), $01)
                                    public_addparam(local4, (Str local3\Field30), $01)
                                    public_addparam(local4, (Str arg0\Field35), $01)
                                    callback($00)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Next
        EndIf
        entitypickmode(arg0\Field69, $02, $00)
        freeentity(local2)
    EndIf
    Return $00
End Function
