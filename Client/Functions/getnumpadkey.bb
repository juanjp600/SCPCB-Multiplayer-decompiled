Function getnumpadkey$()
    Local local0%
    For local0 = $47 To $53 Step $01
        If (keyhit(local0) <> 0) Then
            Select local0
                Case $4F
                    Return (((Str local0) + " ") + "49")
                Case $50
                    Return (((Str local0) + " ") + "50")
                Case $51
                    Return (((Str local0) + " ") + "51")
                Case $4B
                    Return (((Str local0) + " ") + "52")
                Case $4C
                    Return (((Str local0) + " ") + "53")
                Case $4D
                    Return (((Str local0) + " ") + "54")
                Case $47
                    Return (((Str local0) + " ") + "55")
                Case $48
                    Return (((Str local0) + " ") + "56")
                Case $49
                    Return (((Str local0) + " ") + "57")
                Case $53
                    Return (((Str local0) + " ") + "46")
                Case $52
                    Return (((Str local0) + " ") + "48")
            End Select
            Exit
        EndIf
    Next
    Return ""
End Function
