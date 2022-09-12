package dev.garstecki.gcp;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserRepository extends DatastoreRepository<User, String> {
}
