Function openclosedoor%(arg0.doors, arg1%, arg2%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    arg0\Field25 = arg2
    arg0\Field6 = (arg0\Field6 = $00)
    If (arg0\Field21 <> Null) Then
        arg0\Field21\Field6 = (arg0\Field21\Field6 = $00)
        arg0\Field25 = $01
        arg0\Field21\Field25 = $01
    EndIf
    If (arg0\Field6 <> 0) Then
        If (arg0\Field21 <> Null) Then
            arg0\Field21\Field13 = (Float arg0\Field21\Field12)
        EndIf
        arg0\Field13 = (Float arg0\Field12)
    EndIf
    local0 = arg0\Field10
    If (((local0 = $06) Lor (local0 = $07)) <> 0) Then
        local0 = $00
    EndIf
    If (arg1 <> 0) Then
        local1 = rand($00, $02)
        If (local0 = $05) Then
            If (playerroom\Field7\Field6 = $5D) Then
                local1 = $02
            Else
                local1 = rand($00, $01)
            EndIf
        EndIf
        local3 = closedoorsfx(local0, local1)
        If (((local0 = $03) And (arg0\Field4 = $02)) <> 0) Then
            local2 = snd_i\Field2[rand($00, $02)]
        Else
            local2 = opendoorsfx(local0, local1)
        EndIf
        If (arg0\Field27 <> 0) Then
            local3 = snd_i\Field0[local0]
            local2 = snd_i\Field1[local0]
        EndIf
        If (arg0\Field6 <> 0) Then
            arg0\Field17 = playsoundex(local2, camera, arg0\Field0, 10.0, 1.0, $00)
            local4 = local2
        Else
            arg0\Field17 = playsoundex(local3, camera, arg0\Field0, 10.0, 1.0, $00)
            local4 = local3
        EndIf
        If (currentsyncplayer <> Null) Then
            mp_synchronize3dsound(currentsyncplayer, getsoundfilename(local4), arg0\Field0, 10.0, 1.0)
        EndIf
    EndIf
    Return $00
End Function
