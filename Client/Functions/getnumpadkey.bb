Function getnumpadkey$()
    Local local0%
    Local local1%
    For local0 = $47 To $53 Step $01
        If (keyhit(local0) <> 0) Then
            local1 = (Int ((Str local0) + " "))
            Select local0
                Case $4F
                    Return (Str (local1 + $31))
                Case $50
                    Return (Str (local1 + $32))
                Case $51
                    Return (Str (local1 + $33))
                Case $4B
                    Return (Str (local1 + $34))
                Case $4C
                    Return (Str (local1 + $35))
                Case $4D
                    Return (Str (local1 + $36))
                Case $47
                    Return (Str (local1 + $37))
                Case $48
                    Return (Str (local1 + $38))
                Case $49
                    Return (Str (local1 + $39))
                Case $53
                    Return (Str (local1 + $2E))
                Case $52
                    Return (Str (local1 + $30))
            End Select
            Exit
        EndIf
    Next
    Return ""
End Function
