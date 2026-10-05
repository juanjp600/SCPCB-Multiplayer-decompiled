Function clearbullets%()
    Local local0%
    Local local1%
    Local local2%
    For local0 = $00 To (bulletscount - $01) Step $01
        local1 = (local0 * $14)
        local2 = peekint(bulletsbank, (local1 + $00))
        If (local2 <> $00) Then
            freeentity(local2)
        EndIf
    Next
    bulletscount = $00
    Return $00
End Function
