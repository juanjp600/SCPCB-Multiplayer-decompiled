Function updatehotkeys%()
    Local local0%
    If (caninteract() <> 0) Then
        For local0 = $01 To $0A Step $01
            If (keyhit((local0 + $01)) <> 0) Then
                If (selecteditem <> Null) Then
                    selecteditem\Field15 = 0.0
                EndIf
                If (inventory((local0 - $01)) <> Null) Then
                    If (inventory((local0 - $01))\Field16 = $00) Then
                        inventory((local0 - $01)) = Null
                    EndIf
                    If (((wearinghazmat > $00) And (instr(inventory((local0 - $01))\Field1\Field2, "hazmatsuit", $01) = $00)) <> 0) Then
                        setmsg("You cannot use any items while wearing a hazmat suit.")
                        Return $00
                    EndIf
                    If (((instr(inventory((local0 - $01))\Field1\Field2, "scp513", $01) = $00) And ((selecteditem = Null) Or (inventory((local0 - $01)) = selecteditem))) <> 0) Then
                        If (selecteditem = Null) Then
                            selecteditem = inventory((local0 - $01))
                        Else
                            selecteditem = Null
                        EndIf
                        If (((inventory((local0 - $01)) <> Null) And (inventory((local0 - $01))\Field1\Field3 <> $42)) <> 0) Then
                            playsound_strict(picksfx(inventory((local0 - $01))\Field1\Field3))
                        EndIf
                        If (myplayer\Field80 = $00) Then
                            pickupgun(inventory((local0 - $01)))
                        EndIf
                        invopen = $00
                        flushkeys()
                    EndIf
                EndIf
            EndIf
        Next
    ElseIf (myplayer\Field65 < $01) Then
        For local0 = $01 To $0A Step $01
            keyhit((local0 + $01))
        Next
    EndIf
    Return $00
End Function
