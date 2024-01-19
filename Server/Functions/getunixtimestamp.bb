Function getunixtimestamp%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    local0 = createbank($10)
    api_getsystemtime(local0)
    local1 = peekshort(local0, $00)
    local2 = peekshort(local0, $02)
    local3 = (peekshort(local0, $06) - $01)
    local4 = peekshort(local0, $08)
    local5 = peekshort(local0, $0A)
    local6 = peekshort(local0, $0C)
    freebank(local0)
    If (local2 > $02) Then
        local7 = local1
    Else
        local7 = (local1 - $01)
    EndIf
    For local8 = $7B2 To local7 Step $01
        If ((local8 Mod $64) = $00) Then
            If ((local8 Mod $190) = $00) Then
                local3 = (local3 + $01)
            EndIf
        ElseIf ((local8 Mod $04) = $00) Then
            local3 = (local3 + $01)
        EndIf
    Next
    local3 = (local3 + ((local1 - $7B2) * $16D))
    If (local2 > $01) Then
        local3 = (local3 + $1F)
    EndIf
    If (local2 > $02) Then
        local3 = (local3 + $1C)
    EndIf
    If (local2 > $03) Then
        local3 = (local3 + $1F)
    EndIf
    If (local2 > $04) Then
        local3 = (local3 + $1E)
    EndIf
    If (local2 > $05) Then
        local3 = (local3 + $1F)
    EndIf
    If (local2 > $06) Then
        local3 = (local3 + $1E)
    EndIf
    If (local2 > $07) Then
        local3 = (local3 + $1F)
    EndIf
    If (local2 > $08) Then
        local3 = (local3 + $1F)
    EndIf
    If (local2 > $09) Then
        local3 = (local3 + $1E)
    EndIf
    If (local2 > $0A) Then
        local3 = (local3 + $1F)
    EndIf
    If (local2 > $0B) Then
        local3 = (local3 + $1E)
    EndIf
    If (local2 > $0C) Then
        local3 = (local3 + $1F)
    EndIf
    Return ((((local3 * $15180) + (local4 * $E10)) + (local5 * $3C)) + local6)
    Return $00
End Function
