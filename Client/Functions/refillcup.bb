Function refillcup%()
    Local local0.props
    Local local1.items
    Local local2%
    For local0 = Each props
        If (local0\Field4 <> 0) Then
            If (playerroom = local0\Field2) Then
                If (interactobject(local0\Field1, 0.8, $00) <> 0) Then
                    local1 = Null
                    For local2 = $00 To (maxitemamount - $01) Step $01
                        If (inventory(local2) <> Null) Then
                            If (inventory(local2)\Field4\Field2 = $2C) Then
                                local1 = inventory(local2)
                                Exit
                            EndIf
                        EndIf
                    Next
                    If (local1 <> Null) Then
                        removeitem(local1)
                        local1 = createitem("Cup", $2B, 0.0, 0.0, 0.0, $C8, $C8, $C8, 0.2, $00)
                        local1\Field1 = "WATER"
                        local1\Field0 = format(getlocalstring("items", "cupof"), getlocalstring("misc", "water"), "%s")
                        entitytype(local1\Field2, $03, $00)
                        pickitem(local1, $01)
                        playsound_strict(loadtempsound("SFX\SCP\294\Dispense1.ogg"), $00)
                        mp_synchronize3dsound(Null, "SFX\SCP\294\Dispense1.ogg", local0\Field1, 8.0, 1.0)
                        createmsg(getlocalstring("msg", "refill"), 6.0)
                    Else
                        createmsg(getlocalstring("msg", "cup.needed"), 6.0)
                    EndIf
                    Exit
                EndIf
            EndIf
        EndIf
    Next
    Return $00
End Function
