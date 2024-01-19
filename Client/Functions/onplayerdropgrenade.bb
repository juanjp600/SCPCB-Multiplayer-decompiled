Function onplayerdropgrenade%(arg0%)
    Local local0%
    For local0 = $00 To $09 Step $01
        If (inventory(local0) <> Null) Then
            Select arg0
                Case $0D
                    If (inventory(local0)\Field3\Field2 = "grenade") Then
                        removeitem(inventory(local0), $01)
                        Exit
                    EndIf
                Case $0E
                    If (inventory(local0)\Field3\Field2 = "grenadeflashbang") Then
                        removeitem(inventory(local0), $01)
                        Exit
                    EndIf
                Case $0F
                    If (inventory(local0)\Field3\Field2 = "grenadesmoke") Then
                        removeitem(inventory(local0), $01)
                        Exit
                    EndIf
            End Select
        EndIf
    Next
    Return $00
End Function
