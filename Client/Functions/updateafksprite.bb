Function updateafksprite%()
    If (millisecs() > afkspritemillisecs) Then
        afkspriteframe = (afkspriteframe + $01)
        If (afkspriteframe >= $0F) Then
            afkspriteframe = $00
        EndIf
        afkspritemillisecs = (millisecs() + $4B)
    EndIf
    Return $00
End Function
