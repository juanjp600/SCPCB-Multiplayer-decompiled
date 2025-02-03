Function mp_updatecorpses%()
    Local local0.mp_playercorpse
    Local local1%
    Local local2%
    Local local3#
    Local local4%
    local1 = $00
    local2 = $00
    local3 = 1.0
    For local0 = Each mp_playercorpse
        If (entityhidden(local0\Field2) = $00) Then
            hideentity(local0\Field2)
        EndIf
        If (400.0 > entitydistancesquared(local0\Field2, me\Field60)) Then
            If (entityhidden(local0\Field2) <> 0) Then
                showentity(local0\Field2)
            EndIf
            local2 = ((local0\Field11 = mp_getmyindex()) And (0.0 < mp_terminated\Field6))
            local3 = (min(max(((local0\Field10 / 840.0) * 1.0), 0.0), 1.0) * (Float (local2 = $00)))
            If ((((((1.44 > entitydistancesquared(local0\Field1, me\Field60)) And (local1 = $00)) And (selectedcorpse = Null)) And (local0\Field14 = $00)) And entityvisible(local0\Field1, camera)) <> 0) Then
                handentity = local0\Field1
                If ((mo\Field0 And ((((((((((Int me\Field0) Lor invopen) Lor (otheropen <> Null)) Lor (selecteditem <> Null)) Lor (closestitem <> Null)) Lor menuopen) Lor (d_i\Field6 <> Null)) Lor (d_i\Field7 <> Null)) Lor (2.0 <= entitydistancesquared(local0\Field1, me\Field60))) = $00)) <> 0) Then
                    selectedcorpse = local0
                    selectedcorpse\Field17 = 0.0
                    playsound_strict(snd_i\Field44[$02], $00)
                EndIf
                local1 = $01
            EndIf
            If (local0\Field12 > $00) Then
                For local4 = $00 To $09 Step $01
                    If (local0\Field8[local4] <> $00) Then
                        entityalpha(local0\Field8[local4], local3)
                    EndIf
                Next
            EndIf
            entityalpha(local0\Field2, local3)
        EndIf
        local0\Field10 = (local0\Field10 - fps\Field7[$01])
        If (0.0 > local0\Field10) Then
            mp_flushcorpse(local0)
        EndIf
    Next
    If (((selectedcorpse <> Null) And ((((((((Int me\Field0) Lor invopen) Lor (otheropen <> Null)) Lor (selecteditem <> Null)) Lor menuopen) Lor (d_i\Field6 <> Null)) Lor (d_i\Field7 <> Null)) Lor (2.0 <= entitydistancesquared(selectedcorpse\Field1, me\Field60)))) <> 0) Then
        selectedcorpse = Null
    EndIf
    If ((local1 And (((closestitem <> Null) Lor (d_i\Field6 <> Null)) Lor (d_i\Field7 <> Null))) <> 0) Then
        handentity = $00
    EndIf
    If (selectedcorpse <> Null) Then
        selectedcorpse\Field17 = (selectedcorpse\Field17 + (fps\Field7[$00] / 2.0))
        If (100.0 <= selectedcorpse\Field17) Then
            mp_explorecorpse(selectedcorpse)
            selectedcorpse = Null
        EndIf
        If (mo\Field1 <> 0) Then
            selectedcorpse = Null
        EndIf
    EndIf
    Return $00
End Function
