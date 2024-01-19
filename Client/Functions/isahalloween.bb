Function isahalloween%()
    Local local0$
    Local local1%
    local0 = right(left(currentdate(), $06), $03)
    local1 = (Int left(currentdate(), $02))
    Select local0
        Case "Oct"
            Return ((local1 >= $01) And (local1 <= $1F))
        Case "Nov"
            Return (local1 = $01)
    End Select
    Return $00
    Return $00
End Function
