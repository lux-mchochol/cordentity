package com.luxoft.blockchainlab.corda.hyperledger.indy

import com.luxoft.blockchainlab.hyperledger.indy.models.*

class IndyParty(private val webSocket: AgentWebSocketClient, val did: String, val endpoint: String, val verkey: String, val myDid : String) : IndyPartyConnection {
    override fun partyDID(): String = did
    override fun myDID(): String = myDid
    override fun sendCredentialOffer(offer: CredentialOffer) = webSocket.sendClassObject(offer, this)
    override fun receiveCredentialOffer() = webSocket.receiveClassObject<CredentialOffer>(this)
    override fun sendCredentialRequest(request: CredentialRequestInfo) = webSocket.sendClassObject(request, this)
    override fun receiveCredentialRequest() = webSocket.receiveClassObject<CredentialRequestInfo>(this)
    override fun sendCredential(credential: CredentialInfo) = webSocket.sendClassObject(credential, this)
    override fun receiveCredential() = webSocket.receiveClassObject<CredentialInfo>(this)
    override fun sendProofRequest(request: ProofRequest) = webSocket.sendClassObject(request, this)
    override fun receiveProofRequest() = webSocket.receiveClassObject<ProofRequest>(this)
    override fun sendProof(proof: ProofInfo) = webSocket.sendClassObject(proof, this)
    override fun receiveProof() = webSocket.receiveClassObject<ProofInfo>(this)
}

